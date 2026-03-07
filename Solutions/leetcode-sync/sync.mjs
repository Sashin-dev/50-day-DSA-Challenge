import { LeetCode, Credential } from "leetcode-query";
import fs from "fs";
import path from "path";

const SESSION = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfYXV0aF91c2VyX2lkIjoiMzQwNzgzMiIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImFsbGF1dGguYWNjb3VudC5hdXRoX2JhY2tlbmRzLkF1dGhlbnRpY2F0aW9uQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6IjU5ZTAzMmE3YTU5YmE5Y2ZkNTc1NmYzZWQ2YTRhMDVkYzUyMjZkNzE1MmUwNDY5NDgwM2ZhMDFhYWVjOTAxOTQiLCJzZXNzaW9uX3V1aWQiOiJhZjNiNTliNiIsImlkIjozNDA3ODMyLCJlbWFpbCI6InNhc2hpbi5hZ3Jhd2FsQGhvdG1haWwuY29tIiwidXNlcm5hbWUiOiJTYXNoaW5fZGV2IiwidXNlcl9zbHVnIjoiU2FzaGluX2RldiIsImF2YXRhciI6Imh0dHBzOi8vYXNzZXRzLmxlZXRjb2RlLmNvbS91c2Vycy9hdmF0YXJzL2F2YXRhcl8xNjU4ODIwMTIwLnBuZyIsInJlZnJlc2hlZF9hdCI6MTc3Mjc3MTEzOSwiaXAiOiIyNDAxOjQ5MDA6MWNiMDo3NmM2OjQ3MTo4N2M6NGU1MDo3Y2EwIiwiaWRlbnRpdHkiOiJiNjA3MGY5N2RkOTlmZDFhMWY3MjkxNTZlZmQ2MWU4OSIsImRldmljZV93aXRoX2lwIjpbIjk4MDBjYzFmZjQ1MWU0MDMwNWVmOTZhM2ExMmNlMzg5IiwiMjQwMTo0OTAwOjFjYjA6NzZjNjo0NzE6ODdjOjRlNTA6N2NhMCJdfQ.GG9JJXoyyFyCDfD72ObtRmjccRUDdtdLKCYP9j-8Ye8";

const credential = new Credential();
await credential.init(SESSION);
const lc = new LeetCode(credential);

const langExt = {
  java: "java", python3: "py", python: "py",
  cpp: "cpp", javascript: "js", typescript: "ts",
  golang: "go", kotlin: "kt", rust: "rs"
};

let offset = 0;
const pageSize = 20;
const seen = new Set();

console.log("Fetching submissions...\n");

while (true) {
  const page = await lc.submissions({ limit: pageSize, offset });
  if (!page?.length) break;

  for (const sub of page) {
    if (sub.statusDisplay !== "Accepted") continue;
    if (seen.has(sub.titleSlug)) continue; // only latest accepted per problem
    seen.add(sub.titleSlug);

    // ✅ Second call to get actual code
    const detail = await lc.submission(sub.id);
    const code = detail?.code;

    if (!code) {
      console.warn(`⚠ No code returned for: ${sub.titleSlug} (id: ${sub.id})`);
      continue;
    }

    const ext = langExt[sub.lang] || sub.lang;
    const dir = `./solutions/${sub.lang}`;
    fs.mkdirSync(dir, { recursive: true });

    const filename = `${sub.titleSlug}.${ext}`;
    fs.writeFileSync(path.join(dir, filename), code);
    console.log(`✓  ${sub.titleSlug}`);

    // Small delay to stay within rate limits (20 req / 10 sec default)
    await new Promise(r => setTimeout(r, 600));
  }

  if (page.length < pageSize) break;
  offset += pageSize;
}

console.log(`\nDone! ${seen.size} problems saved to ./solutions/`);