package wwwordz.shared;

public class Configs {
	public static final long JOIN_STAGE_DURATION = 1000;
	public static final long PLAY_STAGE_DURATION = 120000;
	public static final long REPORT_STAGE_DURATION = 1000;
	public static final long RANKING_STAGE_DURATION = 1000;
	public static final int ALPHABET_SIZE = 26;
	public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWYZ";
	
	public Configs() {}
	
	public static int getAlphabetSize() {
		return ALPHABET_SIZE;
	}
	public static String getAlphabet() {
		return ALPHABET;
	}
}
