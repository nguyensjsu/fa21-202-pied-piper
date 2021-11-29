# John Monsod's Journal

## My XP Core Value

### Communication
* Some of the things I did to evangelize this core value:
  * I setup/managed our regular team meetings.
  * I facilitated during each sync to discuss outstanding items and issues of concern.
  * I encouraged each team member to discuss their work during syncs.
  * I responded in a timely manner to others' work, and kept everyone up to date on my work.
  * I increased our meeting syncs as we approached our deadline.


## Timeline

### 11/29/2021
#### What I did
#### Blockers
#### What I will do next

### 11/28/2021

#### What I did
* I implemented the Strategy Pattern in the Boss Level of the game, where each phase sets up the appropriate
attack strategy and attacks based on that underlying attack pattern.
* Added more info the the main README for our team.

#### Blockers
* n/a

#### What I will do next
* I will continue to cover the areas where we need to close things out before our fast-approaching deadline.

### 11/26/2021

#### What I did
* I concluded the Boss Level work with a scoring integration, PR submitted and merged all of my accumulated
changes back to main. I worked with Roger to resolve some integration bugs that was from my side.

#### Blockers
* The team received an update on some leaderboard work, but needs to be integrated into an actual GUI, as
well as connected to the Finish screen.

#### What I will do next
* We outlined all remaining outstanding tasks between now and our presentation day. We plan to meet a few
times before then to make sure we close the loop on documentation, videos, source code, etc.

### 11/24/2021

#### What I did
* I Worked on the last part of the Boss Level, enabling a larger ufo that does not get destroyed until
a threshold of hits are achieved.

#### Blockers
* Concerns about the progress of the Leaderboard and the Start Screen, and planning contingencies in
case we need to pick up additional tasks among myself, Sid and Roger.

#### What I will do next
* Circling back on progress at a higher frequency, and focusing on bug fixes and integration work.

### 11/21/2021

#### What I did
* I worked on the Boss Level by introducing different ufo attack patterns, with a swarming effect.
* I made changes to the level to make it more difficult, which is the goal of this final level.
* I committed my changes into my branch.

#### Blockers
* None

#### What I will do next
* I will continue by adding a large enemy that does not get destroyed until a threshold of multiple hits.


### 11/20/2021

#### What I did
* I made code changes to the game levels so that it incorporates a debug observer, which
updates an overlay of debug information on the screen during game play. I refactored the
level classes to rely on a base class so that common aspects of each are in one place.
* Earlier during the in-person class, our team discussed the need to make progress on
two areas - the leaderboard and the main screen.

#### Blockers
* None, but concerns around contributions from a couple of members are to be monitored.

#### What I will do next
* Continue on our respective tasks, but in particular, we will want to see progress on
the the leaderboard and the main screen.


### 11/19/2021

* Provided PR review feedback on Sid's submission.

### 11/17/2021

#### What I did
* Our sync was with myself, Roger and Sid.
* I created a new level in the game, called "Boss Level". As per discussed with the team,
this is meant to be the final level after the first 2 normal game levels, to serve as
the finale. So far, it is only a replica of Level 2, but I applied the transition from
Level 2 to the Boss Level instead of ending the game at that point.

#### Blockers
* We are a little uncertain about the progress for tasks assigned to Hashmitha and Faizali
since we have not received updates yet. Specifically, the Leaderboard and the Main Screen
are potentially in question at this time.

#### What I will do next
* We will continue to add improvements to the game as assigned to each of us. Mainly, this
will be the UI screens and the underlying functionality associated with each.


### 11/13/2021

#### What I did
* Identified all User Stories for what we will do in our project.
* Drilled down the details involved in each story, and identified corresponding tasks.
* I added all tasks to our Task Board and assigned as we agreed as a team.
* Discussed trade-offs with some tasks, determined which were high, medium and low priorities.

#### Blockers
* Still needed to determine whether we could render plain text as an overlay to the screens
or if we will need to generate graphical assets for each character we need to render.

#### What I will do next
* Work on our respective tasks.

### 11/10/2021

#### What I did
* Went over the possible enhancements we could pursue for the game. I provided my list of
  suggestions, and others provided theirs as well. We discussed relative merit of each and
  came up with a short list of the features we wanted to tackle.
#### Blockers
* None
#### What I will do next
* Create tickets for all the tasks will do, designate some of these to each of us. Start
  working on each.

### 11/05/2021

#### What I did
* Met with the team to decide on the Greenfoot game to use as starter code for our project.
  Discussed each person's suggestion, trade-offs, and potential feature enhancements.
* Demo'd my research into my suggestion, [P-TYPE](https://www.greenfoot.org/scenarios/13388),
  the code structure of this game, the way I was able to use Intellij IDE to build the source
  (while testing runtime using the Greenfoot IDE), and the potential to build on top of it.
* Team made decision to go with my suggestion. We outlined the next set of goals we need to do,
  namely, reviewing the code, identifying potential enhancements & patterns we might employ,
  outlining User Stories and designating Tasks. We also created a Kanban board in Github
  and named our project *Q-TYPE*. 

#### Blockers
* Potentially, in determining the level of complexity of the tasks we will undertake.
* Investigating if we have the ability to overlay regular text onto the screens, or if we will
  need to generate font graphics as a way to overlay.

#### What I will do next
* Determine stories and tasks, designate them to each member so we can work in parallel.

### 11/04/2021

#### What I did
* Researched Greenfoot candidate games that I will suggest to build on top of. My choice is
  a game called [P-TYPE](https://www.greenfoot.org/scenarios/13388), a space shoot-alien-ships game.
  I chose it because it looked to have a clean starting point, but also was missing some key
  aspects that we have the opportunity to develop. For example, no scores are provided, and
  there are only 2 levels. We could also potentially enhance the game dynamics with additional
  targets, patterns, effects, backgrounds, etc. Lastly, it may be good to provide a leaderboard.

#### Blockers
* Potentially whether the choices we are considering are good or not.

#### What I will do next
* Deciding on which game to pursue.

### 11/03/2021

#### What I did
* Meeting with the team
	* Discussed choices for our project: Greenfoot, Processing, or Custom Web/Mobile App.
	* Custom app may have been good to allow for different sub-systems for each to focus on.
    For example, one person to deal with the database and its data access layer, another
    person to build the NodeJS APIs, another for the UI and application logic, etc.
    However, determined that the time/scope of such work may not be optimal.
	* Considered Processing as well, but decided against it due to the limited Sktechpad IDE
    and the learning curve in using its abstractions.
	* Decided to pursue building/enhancing a game from Greenfoot. It was closer to using native
    Java, and already has a familiar dev environment from using BlueJ.
	* Each of us chose a XP Core Value to evangelize for the team. I chose Communication, since
    I was already facilitating the cadence of conversations, encouraging collaboration among
    all of us.

#### Blockers
* None

#### What I will do next
* Resolved to determine candidate games to consider for our next sync, so we can finalize
  which one to build on and enhance.


### 10/30/2021

#### What I did
* Prep for team syncs
	* Setup weekly meetings
	* Setup meeting doc

#### Blockers
* None

#### What I will do next
* Organize ourselves
* Understand the requirements



