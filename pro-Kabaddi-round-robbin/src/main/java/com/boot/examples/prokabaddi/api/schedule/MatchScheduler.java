package com.boot.examples.prokabaddi.api.schedule;

import java.util.List;
import java.util.Map;

import com.boot.examples.prokabaddi.api.common.Team;
import com.boot.examples.prokabaddi.api.common.Match;

public interface MatchScheduler {
	
	List<Match> generateSchedule(Map<Integer, Team> allTeams);
}
