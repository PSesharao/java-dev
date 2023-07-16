package shufflechar1;

public class ApplicationShuffle {
	public static void main(String[] args) {

		String inputString = ShuffleChars.getValidatedAlphaString();
		ShuffleChars callingObj = new ShuffleChars(inputString);
		String shuffledString = callingObj.getShuffledChar();
		System.out.println(shuffledString);

	}
}
