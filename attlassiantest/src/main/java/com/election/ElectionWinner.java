package com.election;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionWinner {

    private int votesPerPerson;
    private int maxGrade;
    private int iteratorCount;

    public ElectionWinner() {

    }

    public ElectionWinner(int votesPerPerson, int maxGrade) {
        this.votesPerPerson = votesPerPerson;
        this.maxGrade = maxGrade;
    }


    public String findTheWinnerWhenSingleVote(List<String> votes) {

        if (votes == null || votes.isEmpty()) {
            return "";
        }

        Map<String, Integer> candidateVotesCount = new HashMap<>();

        String winner = "";
        Integer maxVotes = Integer.MIN_VALUE;

        for (String vote : votes) {
            if (candidateVotesCount.get(vote) == null) {
                candidateVotesCount.put(vote, 1);
            } else {
                candidateVotesCount.put(vote, candidateVotesCount.get(vote) + 1);
            }

            if (maxVotes < candidateVotesCount.get(vote)) {
                maxVotes = candidateVotesCount.get(vote);
                winner = vote;
            }
        }
        return winner;
    }


    public String findTheWinner(List<CandidateGrade> votes) {

        if (votes == null || votes.isEmpty()) {
            return "";
        }

        int thresholdVotesToWin = getThresholdVotesToWin(votes);

        Map<String, Integer> candidateVotesCount = new HashMap<>();

        String winner = "";
        Integer maxVotes = Integer.MIN_VALUE;

        for (CandidateGrade vote : votes) {
            iteratorCount++;

            if (candidateVotesCount.get(vote.getCandidateName()) == null) {
                candidateVotesCount.put(vote.getCandidateName(), vote.getGrade());
            } else {
                candidateVotesCount.put(vote.getCandidateName(), candidateVotesCount.get(vote.getCandidateName()) + vote.getGrade());
            }

            if (maxVotes < candidateVotesCount.get(vote.getCandidateName())) {
                maxVotes = candidateVotesCount.get(vote.getCandidateName());
                if (maxVotes > thresholdVotesToWin) {
                    winner = vote.getCandidateName();
                    return winner;
                }
                winner = vote.getCandidateName();
            }
        }

        return winner;
    }

    private int getThresholdVotesToWin(List<CandidateGrade> votes) {
        int numOfPeople = votes.size() / votesPerPerson;
        return (numOfPeople * maxGrade) / 2;
    }

    public int getIteratorCount() {
        return iteratorCount;
    }

    public void setIteratorCount(int iteratorCount) {
        this.iteratorCount = iteratorCount;
    }
}
