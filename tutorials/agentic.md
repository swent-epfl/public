# Agentic Development &ndash; A Curated Playlist

This is all **optional**&mdash;there will be no questions on the exam about any of this. The goal of this playlist is to teach the mechanics of actually setting up and driving an agentic workflow.

The table below has three sections:
- Getting Set Up: Five videos that help you set up your basic agentic pipeline.
- Worth Your Time: An unordered list that we, the staff, believe would be useful for everyone in SwEnt.
- Going Further: Advanced topics best suited for SwEnt students who are already using agents daily.

> [!IMPORTANT]  
> One doesn't learn that much from just watching videos... the true knowledge comes from using the tools, reading the docs, going through the vendor's own guides to get a clean setup, etc. Treat this list of videos as a warmup, not a substitute for the workout.

<table>
<tr><td colspan="4"><br><b>Getting Set Up</b> (watch in order)</td></tr>
<tr>
<td align="center"><sub>1.</sub></td>
<td><a href="https://www.youtube.com/watch?v=h7QJL2_gEXA">How to Use CLAUDE.md in Claude Code in 5 Minutes</a><br><sub>Aleksander Stensby</sub></td>
<td align="center"><sub>5 min</sub></td>
<td>Talks about the conventions file, concretely, as persistent project memory the agent reads at the start of every session: architecture, standards, and the mistakes it has already made. Watch this before you write any SwEnt project code.<br><sub>⚠️ Claude Code-specific; this is the file the lecture calls <code>AGENTS.md</code>, but see note at the bottom of this page.</sub></td>
</tr>
<tr>
<td align="center"><sub>2.</sub></td>
<td><a href="https://www.youtube.com/watch?v=I1EGbrH5Xdk">Master Context in Claude Code in 5 Minutes</a><br><sub>Aleksander Stensby</sub></td>
<td align="center"><sub>5 min</sub></td>
<td>Too much context confuses the agent, too little makes it hallucinate. How to see what is in the window, when to clear it, and how to carry state across sessions with a handover file.</td>
</tr>
<tr>
<td align="center"><sub>3.</sub></td>
<td><a href="https://www.youtube.com/watch?v=5fhcklZe-qE">Everything You Need to Know About Coding with AI</a><br><sub>ForrestKnight</sub></td>
<td align="center"><sub>~15 min</sub></td>
<td>Set the foundation once (index the codebase, write your rules, etc.) then treat every task as a Sprint task: small, isolated, testable. Review the output as if you were pair-programming with a junior intern.<br><sub>⚠️ Warp-sponsored, but the principles are tool-agnostic. His three-agent example is the same pattern as we saw in lecture. Ignore the aside on running agents on independent tasks across git worktrees&mdash;he himself says he rarely does it, and it's how you end up with the 47-file PR from hell.</sub></td>
</tr>
<tr>
<td align="center"><sub>4.</sub></td>
<td><a href="https://www.youtube.com/watch?v=RhaF4LVAVng">How I Code With AI Agents (Spec-Driven Development)</a><br><sub>Owain Lewis</sub></td>
<td align="center"><sub>19 min</sub></td>
<td>Write a short spec first, then have the agent implement it in small reviewable steps. This is how you supply the two things we said in lecture that the agent cannot invent for you: decomposition and acceptance criteria. Maps directly to a specify → design → implement → test workflow.</td>
</tr>
<tr>
<td align="center"><sub>5.</sub></td>
<td><a href="https://www.youtube.com/watch?v=As2xy_cSx00">How I Review AI-Generated Code</a><br><sub>Owain Lewis</sub></td>
<td align="center"><sub>14 min</sub></td>
<td>AI-generated code carries measurably more bugs, security issues and logic errors than human-written code. Owain describes four levels of review, from automated checks up to the human who signs off. This connects straight to the CI and hooks you already have from the bootcamp.</td>
</tr>
<!------------------------------------------------------------------------------------------------------------------------------------->
<tr><td colspan="4"><br><b>Worth Your Time</b> (for everyone)</td></tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=zMM5zqesL1g">Stop Wasting Tokens: The Art of Context Engineering</a><br><sub>Addy Osmani (Google)</sub></td>
<td align="center"><sub>~15 min</sub></td>
<td>Treat the context window like RAM: it's fixed, you choose what's resident, and something gets evicted whether you decide it or not. Addy then presents LangChain's four patterns&mdash;write, select, compress, isolate&mdash;plus habits that will be useful when your project grows: prune boilerplate, share specific schemas, set clear constraint boundaries.<br><sub>⚠️ Introduces a prompt-building tool at context.addy.ie.</sub></td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=rT2Del5pwg4">Developer Experience in the Age of AI Coding Agents</a><br><sub>Max Kanat-Alexander</sub></td>
<td align="center"><sub>~20 min</sub></td>
<td>What makes a codebase good for agents is exactly what makes it good for humans: robust tests, useful error messages, documentation, a structure that makes sense. Bad codebases produce a vicious cycle of bad agent PRs; clean ones compound the other way.</td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=91B_v-wOaws">I Have Spent 500+ Hours Programming With AI</a><br><sub>ForrestKnight</sub></td>
<td align="center"><sub>~15 min</sub></td>
<td>Takes one task ("build a collaborative document editor") and gives it to the agent three times: with a vague prompt, a moderate one, and a carefully specified one. Then shows what comes back each time. This exercise is worth repeating on something from your own project. Take-home lesson: always give the agent a way to verify its own work.<br><sub>⚠️ JetBrains-sponsored.</sub></td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=mViFYTwWvcM">Spec-Driven Development: AI Assisted Coding Explained</a><br><sub>Brad Stoneman (IBM)</sub></td>
<td align="center"><sub>9 min</sub></td>
<td>This is the "why" behind the spec-driven workflow shown in video #4 above (in "Getting Set Up"). The specification becomes a contract that drives design, implementation, and test generation.</td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=v4F1gFy-hqg">Software Fundamentals Matter More Than Ever</a><br><sub>Matt Pocock</sub></td>
<td align="center"><sub>~15 min</sub></td>
<td>From someone who built a Claude Code course and came out convinced that fundamentals matter more, not less. He shows how agents amplify good architecture and bad decisions alike, at scale and speed.<br><sub>⚠️ Deliberately skeptical of spec-driven development, so worth watching against the Owain Lewis video above.</sub></td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=4wMRXmLpdA8">AI in the SDLC: Rethinking AI Coding Tools &amp; AI Agents</a><br><sub>Brad Stoneman (IBM)</sub></td>
<td align="center"><sub>9 min</sub></td>
<td>Opens with the controlled study where developers believed they were 20% faster and were measurably 20% slower. Coding faster in one box does not help if requirements, testing and deployment stay slow. This is the empirical version of our lecture&#x27;s "why does agentic not speed up sw dev by 10×".</td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=wEsjK3Smovw">From Writing Code to Managing Agents</a><br><sub>Mihail Eric (Stanford)</sub></td>
<td align="center"><sub>~15 min</sub></td>
<td>More agents does not mean a better system: left to themselves, they can make things considerably worse, and handling several well is what he calls "the last boss."</td>
</tr>
<!------------------------------------------------------------------------------------------------------------------------------------->
<tr><td colspan="4"><br><b>Going Further</b> (if you already use agents daily)</td></tr>
<tr>
<td align="center">&nbsp;</td>
<td><a href="https://www.youtube.com/watch?v=3pKL7ixauAc">The Multi-Agent Code Review Workflow For My Production Android Apps</a><br><sub>Philipp Lackner</sub></td>
<td align="center"><sub>~30 min</sub></td>
<td>Philipp hands over his full production review pipeline: a skip-checker, three parallel reviewers working in independent contexts (bugs, conventions, security), an issue-validator that grades severity so only blocking issues get auto-fixed, and a verify-audit agent that makes every finding carry a file and line number as proof. That proof step is a highly transferable idea. He emphasizes that this does not replace manual review, it just shrinks what a human has to read.<br>
<sub>⚠️ JetBrains-sponsored. The only Android-specific video here.</sub></td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=96jN2OCOfLs">From Vibe Coding to Agentic Engineering</a><br><sub>Andrej Karpathy</sub></td>
<td align="center"><sub>~30 min</sub></td>
<td>The person who coined “vibe coding” on why he has never felt more behind as a programmer. The fullest treatment of the shift that our lectures on agentic sw dev are about. Makes a number of thought-provoking points.</td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=ClWD8OEYgp8">One Developer, Two Dozen Agents, Zero Alignment</a><br><sub>Maggie Appleton (GitHub Next)</sub></td>
<td align="center"><sub>~20 min</sub></td>
<td>Agents are built for one developer; software is built by teams. Opens on the "wall of terminals" image of peak individual productivity and argues it falls apart at team scale, where you have many agents but no shared context. This is a problem your seven-person SwEnt team will likely hit.<br><sub>⚠️ Second half covers a research prototype.</sub></td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=mEeiw-9OC2Q">How Elite Software Engineers Are Using Agents</a><br><sub>Rob Bos (Microsoft)</sub></td>
<td align="center"><sub>~50 min</sub></td>
<td>Engineers spend only ~2 hours a day actually writing code, while the rest of their time goes to understanding the problem, reviewing, and coordinating. So making the typing faster barely moves anything; what changes your output is giving the agent good context, breaking work into pieces it can handle, and being a strong reviewer of what comes back. This is the Amdahl argument from lecture, arrived at from the other end.</td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=pP_dSNz_EdQ">The Unreasonable Effectiveness of Prompt Learning</a><br><sub>Aparna Dhinakaran</sub></td>
<td align="center"><sub>~20 min</sub></td>
<td>Measures whether telling an agent why its previous attempts failed makes it better. It does, and substantially so.  This provides the empirical case for updating your conventions file every single time the agent repeats a mistake.<br><sub>⚠️ Evaluation-pipeline heavy; the transferable part is the conventions-file habit.</sub></td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=qyPCVqFUyDo">We Cut 80% of Claude Code&#x27;s Prompt</a><br><sub>Boris Cherny (Anthropic)</sub></td>
<td align="center"><sub>~36 min</sub></td>
<td>Claude Code's creator explains how they rebuild the tool for every model release: delete the system prompt entirely, then add lines back one at a time only when the model repeatedly stumbles on the same thing. His advice for your setup: every 6 months, delete your <code>CLAUDE.md</code>, your skills, your hooks, and see what the model still needs. Verification is the single thing people most often get wrong&mdash;give the model a way to check its own work and it will run a long way unattended; don't, and it gets stuck.
<sub>⚠️ Assumes you know what a system prompt is; it is the hidden standing instructions a tool sends the model ahead of your message.</sub></td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=CEvIs9y1uog">Don&#x27;t Build Agents, Build Skills Instead</a><br><sub>Barry Zhang &amp; Mahesh Murag (Anthropic)</sub></td>
<td align="center"><sub>~15 min</sub></td>
<td>Package your team&#x27;s recurring workflows (like PR review, testing, conventions) as reusable skills, rather than building a specialized agent for every task.<br><sub>⚠️ Written for people building on agent platforms.</sub></td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=D7_ipDqhtwk">How We Build Effective Agents</a><br><sub>Barry Zhang (Anthropic)</sub></td>
<td align="center"><sub>15 min</sub></td>
<td>Letting an agent choose its own steps buys flexibility and costs tokens, latency, and debuggability&mdash;a fixed pipeline behaves the same way every time, whereas an agent might take 4 steps or 40, you don't know. So use autonomous agents only where the task needs it; if you can draw the decision tree, just build the decision tree. And keep them for environments where mistakes surface immediately (coding with tests and CI is the good case).</td>
</tr>
<tr>
<td align="center"><sub>&nbsp;</sub></td>
<td><a href="https://www.youtube.com/watch?v=vJEy3nP2_C8">Most Valuable Skill of 2026: Managing AI Agents</a><br><sub>Ryan Carson &amp; Greg Isenberg</sub></td>
<td align="center"><sub>~45 min</sub></td>
<td>Teams of agents in cloud VMs, parallel isolated sessions, and a “software factory” running around the clock.<br><sub>⚠️ Read it against the Amdahl slide — the ceiling that slide argues for is exactly what this framing ignores.</sub></td>
</tr>
</table>

---

> [!CAUTION]
> Most of these videos use Claude Code, but the ideas are relevant regardless of which tool you use. One issue is that we use `AGENTS.md`, which is the cross-vendor standard that Codex, Cursor, Copilot, Windsurf, etc. all read. Claude Code is the exception: it does not read `AGENTS.md`, and it doesn't tell you it's ignoring it. If you use Claude Code, run `ln -s AGENTS.md CLAUDE.md` once in your repo root, and everything will be fine.

