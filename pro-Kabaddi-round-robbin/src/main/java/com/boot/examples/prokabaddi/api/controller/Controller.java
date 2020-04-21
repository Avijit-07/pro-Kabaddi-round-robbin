package com.boot.examples.prokabaddi.api.controller;

import com.boot.examples.prokabaddi.api.common.Team;
import com.boot.examples.prokabaddi.api.common.dao.TeamDao;
import com.boot.examples.prokabaddi.api.common.dao.impl.TeamDaoImpl;
import com.boot.examples.prokabaddi.api.common.Match;
import com.boot.examples.prokabaddi.api.schedule.MatchScheduler;
import com.boot.examples.prokabaddi.api.schedule.impl.MatchSchedularImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Controller {

	TeamDao teamDao= new TeamDaoImpl();
	MatchScheduler matchScheduler= new MatchSchedularImpl();

	@GetMapping("/teams")
	public HashMap<Integer, Team> getAllTeams(){
		return (HashMap<Integer, Team>) (teamDao.getAllTeams());
	}
	
	@GetMapping("/schedule")
	public List<Match> getAllMatches(){
		return matchScheduler.generateSchedule(teamDao.getAllTeams());
	}
	
	
	@GetMapping("/scheduleDetails")
	public StringBuilder getAllMatches1(){
		List<Match> allMatches=matchScheduler.generateSchedule(teamDao.getAllTeams());
		
		StringBuilder schedule= new StringBuilder();
		schedule.append("     Team1   vs     Team2    --> Location  ---> Date \n ");
		schedule.append("\n");
		schedule.append("====================================================================================");
		schedule.append("\n");
		schedule.append(System.getProperty("line.separator"));
		for(Match m: allMatches) {
			schedule.append("     "+m.getFirstTeam().getName()+" vs "+m.getSecondTeam().getName()+" --> "+m.getLocation()+" ---> "+m.getDate()+"  ");
			schedule.append("\n");
		}
		System.out.println(schedule);
		
		return schedule;
	}
}
