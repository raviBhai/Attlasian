package com.election;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ElectionWinnerTest {


    @Test
    public void when_onlyOneVotePerVoter_then_getWinner() {

        ElectionWinner electionWinner = new ElectionWinner();
        List<String> votes = getSingleVotes();
        String theWinner = electionWinner.findTheWinnerWhenSingleVote(votes);
        assertTrue(theWinner.equals("b"));

    }

    @Test
    public void when_gradedVoterPerVoter_then_getWinner() {

        ElectionWinner electionWinner = new ElectionWinner(3, 3);
        List<CandidateGrade> gradedVotes = getGradedVotes();
        String theWinner = electionWinner.findTheWinner(gradedVotes);
        assertTrue(theWinner.equals("b"));
        assertTrue(electionWinner.getIteratorCount() == 7);
    }

    private List<String> getSingleVotes() {
        List<String> votes = new ArrayList<>();
        votes.add("b");
        votes.add("b");
        votes.add("a");
        votes.add("a");
        return votes;
    }

    private List<CandidateGrade> getGradedVotes() {
        return Arrays.asList(
                new CandidateGrade("b", 3),
                new CandidateGrade("a", 2),
                new CandidateGrade("c", 1),

                new CandidateGrade("b", 3),
                new CandidateGrade("a", 2),
                new CandidateGrade("c", 1),

                new CandidateGrade("b", 3),
                new CandidateGrade("a", 2),
                new CandidateGrade("c", 1),

                new CandidateGrade("b", 3),
                new CandidateGrade("a", 2),
                new CandidateGrade("c", 1)


        );

    }

}
