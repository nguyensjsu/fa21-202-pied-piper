# Individual Report

---

## 11/03/2021

### What was done?
- John setup the meeting notes document and the Sprint task sheet.
- Roger setup the git.
- We discussed about everyone's expertise and area of interest and looked at previous semester student's project to get an idea how to go about our poject.
- We voted upon whether to build a game or to develop an interactive application (majority voted to build a game).
- We split up core XP values among the team members (I will be taking care of the Feedback).

### What is planned for next meet?
- Everyone will research some games on greenfoot and present the best 1-2 games that they find.
- Decide upon the final game to work upon based on voting by team members.

### Was there any block?
- N/A

---

## 11/05/2021

### What was done?
- Everyone presented their best games and we finalized a game that we will be working on (PTYPE - [link to the game](https://www.greenfoot.org/scenarios/13388))

### What is planned for next meet?
- Play around with the game and find what features can be added, think about where and which design patterns can be used.
- Review the code of the game and understand the underlying logic.
- Identify user stories and designate tasks to each team member.

### Was there any block?
- N/A

---

## 11/10/2021

### What was done?
- Everyone presented with their set of features/tweaks that can be implemented to the list.
- Created a possible list of features we can add to the existing game.
- Created a wireframe for the Leaderboard Screen.

### What is planned for next meet?
- Research if String can be displayed on the screen, without having a static image of the text.
- Provide priorities to the user stories and assign everyone a task.

### Was there any block?
- N/A

---

## 11/13/2021

### What was done?
- Prioritized user stories based on the time it will take to implement and the importance of the feature in the game.
- John Created the Kanban board on our Github repo and assigned tickets to everyone.
- I will be working on the Setting Screen.
- Briefly discussed about possible design patterns that can be implemented.

### What is planned for next meet?
- Show progress and code review.
- Finalize Design Patterns to be implemented for each task.

### Was there any block?
- N/A

---

## 11/17/2021

### What was done?
- Created the Settings Screen as a new Actor class in Greenfoot, for now it just has a placeholder image.
- Added navigation from Start Screen to Settings Screen (by pressing 'S' on the keyboard) and back again to the Start Screen (by pressing 'esc on the keyboard).
- John created the Boss Level, right now he has just replicated the boss level and will later add more difficult UFO patterns to it.
- Roger created the display for player using Observer design pattern.
- Having the Feedback XP core value, I ensured the code review was done correctly and encouraged everyone to provide feedbak on each other's work.

### What is planned for next meet?
- I plan to add a slider/buttons for the Settings Screen to adjust background music and sound effects.

### Was there any block?
- Feedback from Faizali and Hashmita was not possible since they were not present in the project sync meet.

---

## 11/20/2021

### What was done?
- I Incorporated buttons on the settings screen, created a Label class which inherits Actor class so that I could take advantage of the onClick method of the Actor.
- Implemented Command design patterns to implement different functionalities of the buttons on the Settings Screen.
- I Added Labels on the Settings Screen to display the current volume level of the background music and sound effects.
- John added a Debugger Display on the screen using observer pattern.
- Roger fixed the bugs with negative Lives being displayed.
- Faiz mentioned about his work about the Leaderboard Screen (couldn't review the code).
- Hashmita hasn't updated about her work yet.

### What is planned for next meet?
- I will start working on a new task (Finish Screen).
- Roger will star a new task (Display Player Score).
- John will be continuing work on the Boss Level.

### Was there any block?
- Couldn't implement a slider for adjusting volume, it was taking a lot of time and couldn't find good resources on how to implement a slider in greenfoot on the internet.

---

## 11/24/2021

### What was done?
- I created the Finish Screen (this screen is displayed when the player finishes all the levels of the game).
- Also created a placeholder for the Leaderboard Screen (placeholder will be replaced when Faizali's code is integrated to greenfoot).
- Faizali provided working code for the Leaderboard Screen, though it was a console application code and needs to be integrated to greenfoot such that it displays the Leaderboard on the screen.
- John introduced a mega UFO on the boss level.
- Roger implemented the Player Score display using observer pattern.

### What is planned for next meet?
- I will start working on the Player alias input (Transition Screen) and creating a Leaderboard HashMap (having player alias and score).

### Was there any block?
- The finish screen created a bug which caused the game to restart automatically on the Leaderboard screen and causing negative lives and random generation of UFOs on the screen.

---

## 11/29/2021

### What was done?
- I finished integrating Faizali's Leaderboard Screen code to the greenfoor project.
- I also finished the Transition Screen (user can now input their player alias), it also displays alias name and score on the screen before Leaderboard Screen.
- John finished his work on the Boss Level and implemented Strategy pattern to create more difficult UFO patterns.
- John updated the ReadMe, added UML diagrams and architecture diagram to the repo's ReadMe.
- Roger worked on the burndown chart and started working on the user story video.

### What is planned for next meet?
- Roger has to complete the User Story video.
- I have to fix bugs causing restart of game on leaderboard screen and cauisng negative lives. (These were the major bugs found, we will focus on this more and minor bugs are ignored for now)

### Was there any block?
- N/A

---

## 12/01/2021

### What was done?
- I fixed some of the bugs and pushed the final code to the repo.
- Roger completed the User story video.
- John and Roger are going over my Pull Request, so that it can be merged to the main branch.
- We briefly discussed on how to go about the slide presentation

### What is planned for next meet?
- Finalize the slide content and assign slide to each one to present.

### Was there any block?
- Faizali was not present in the team sync meet, so couldn't assign him which slides to present.

---

## 12/02/2021

### What was done?
- Resolved code conflicts together, before merging it to the main branch.
- Created the final slide presentation, went over the slides once.
- Finalized that we will all individually record our parts of the slide presentation and then stitch it all together.

### What is planned for next meet?
- I have to stitch all the videos together provided by the teammates to create a final presention video.

### Was there any block?
- N/A

---

## 12/03/2021

### What was done?
- Complied the final presentation video by stitching all the videos together.
- Updated the ReadMe (Added my contribution summary and attached a link to the final presentation video).

### What is planned for next meet?
- Present live demo in the class.

### Was there any block?
- N/A

---
