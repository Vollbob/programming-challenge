package model;

public class FootballTeamData {
	private String team;
	private int games;
	private int wins;
	private int losses;
	private int draws;
	private int goals;
	private int goals_allowed;
	private int points;
	
	public FootballTeamData() {
		
	}
	
	public FootballTeamData(String team, int games, int wins, int losses, int draws, int goals, int goals_allowed, int points) {
		this.setTeam(team);
		this.setGames(games);
		this.setWins(wins);
		this.setLosses(losses);
		this.setDraws(draws);
		this.setGoals(goals);
		this.setGoals_allowed(goals_allowed);
		this.setPoints(points);
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getGoals_allowed() {
		return goals_allowed;
	}

	public void setGoals_allowed(int goals_allowed) {
		this.goals_allowed = goals_allowed;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
