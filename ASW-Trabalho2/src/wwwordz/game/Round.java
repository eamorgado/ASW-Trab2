package wwwordz.game;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import wwwordz.puzzle.Generator;
import wwwordz.shared.Configs;
import wwwordz.shared.Puzzle;
import wwwordz.shared.Rank;

/**
 * A round has 4 sequential stages
 *	join - client join the round
 *	play - client retrieves puzzle and player solve puzzle
 *	report - clients report points back to server
 *	ranking - clients ask for rankings
 *	
 *	Each stage has a specific duration and the round method can only be 
 *   executed within a limited time frame. 
 *  
 *  The duration of each stage can be checked or changed with static 
 *   setters and getters. 
 *   
 * The following method should be executed in the associated stages.
 *	register() - join
 *	getPuzzle() - play
 *	setPoints() - register
 *	getRanking() - ranking
 *	When executed outside their stages these methods raise a WWWordzException.
 * 
 * @author Eduardo Morgado (up201706894)
 * @author Ângelo Gomes (up201703990)
 * @since April 2020
 */
public class Round {
	private Date end, join, play, report,ranking;
	Puzzle puzzle;
	Map<String,Player> roundPlayers;
	
	private static enum Durations{
		JOIN(Configs.JOIN_STAGE_DURATION),
		PLAY(Configs.PLAY_STAGE_DURATION),
		RANKING(Configs.RANKING_STAGE_DURATION),
		REPORT(Configs.REPORT_STAGE_DURATION);
		
		private long stageDuration;
		Durations(long duration){
			this.stageDuration = duration;
		}
		public long getStageDuration() {
			return stageDuration;
		}
		public void setStageDuration(long duration) {
			stageDuration = duration;
		}
	}
	
	static enum Relative{before, after}
	static enum Stage{join,play,ranking,report}
	
	Round(){
		puzzle = new Generator().generate();
		roundPlayers = new HashMap<>();
	}
	
	/**
	 * Get duration of join stage in milliseconds
	 * @return long time
	 */
	static long getJoinStageDuration() {
		return Durations.JOIN.getStageDuration();
	}
	
	/**
	 * Get duration of play stage in milliseconds
	 * @return time
	 */
	static long getPlayStageDuration() {
		return Durations.PLAY.getStageDuration();
	}
	
	/**
	 * Get table for this round
	 */
	Puzzle getPuzzle() {}
	
	/**
	 * Get list of players in the round sorted by points
	 * @return List<Rank> sorted list of rankings
	 */
	List<Rank> getRanking(){}
	
	/**
	 * Duration of ranking stage in milliseconds
	 */
	static long getRankingStageDuration() {
		return Durations.RANKING.getStageDuration();
	}
	
	/**
	 * Get duration of report stage in milliseconds
	 */
	static long getReportStageDuration() {
		return Durations.REPORT.getStageDuration();
	}
	
	/**
	 * Complete duration of round (all stages)
	 */
	static long getRoundDuration() {
		long roundDuration = 0L;
		for(Durations duration : Durations.values())
			roundDuration += duration.getStageDuration();
		return roundDuration;
	}
	
	/**
	 * Time in milliseconds to the next play stage
	 */
	long getTimetoNextPlay() {}
	
	/**
	 * Register user with nick and password for this round
	 * @param nick
	 * @param password
	 * @return
	 */
	long register(String nick,String password) {}
	
	/**
	 * Change join stage
	 */
	static void setJoinStageDuration(long joinStageDuration) {
		Durations.JOIN.setStageDuration(joinStageDuration);
	}
	
	/**
	 * Change play stage
	 */
	static void setPlayStageDuration(long playStageDuration) {
		Durations.PLAY.setStageDuration(playStageDuration);
	}
	
	/**
	 * Set number of points obtained by user in this round
	 */
	void setPoints(String nick, int points) {}
	
	/**
	 * Change ranking stage
	 */
	static void setRankingStageSuration(long rankingStageDuration) {
		Durations.RANKING.setStageDuration(rankingStageDuration);
	}
	
	/**
	 * Change report stage
	 */
	static void setReportStageDuration(long reportStageDuration) {
		Durations.REPORT.setStageDuration(reportStageDuration);
	}
	
	
}