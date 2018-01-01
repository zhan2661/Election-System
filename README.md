# Election-System
**Course Project**
Builded a Instant Runoff Voting (IRV) or Ranked Choice Voting (RCV); which is a system in each voter selects ranks candidates for a position according to preference rather than selecting only their first choice. 

    Winners: At any point, if any candidate has more than 50% of the total votes, that candidate is the winner and the results are complete.
    Ties: At any point, if all remaining candidates have an equal number of votes there is an all-way tie and the results are complete.
    Drop Lowest: If there is not a winner or tie, the candidate(s) with the lowest number of votes are dropped from the election. There may be multiple such candidates. Another round of tallying is done in which votes are recalculated based on the new, smaller pool of candidates.
    All Votes Complete: It is assumed that each vote has a complete ordering of the candidates from 1 to N. Additional rules would need to be introduced to deal with partial or improper rankings.

