/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 


		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str1x = preProcess(str1);
		String str2x = preProcess(str2);
		String str1n = "";
		String str2n = "";
		
		for(int i=0;i<str1x.length();i++) {
			if(str1x.charAt(i)>='a'&&str1x.charAt(i)<='z') {
			str1n += str1x.charAt(i);
		}	
	}
		for(int i=0;i<str2x.length();i++) {
			if(str2x.charAt(i)>='a'&& str2x.charAt(i)<='z') {
			str2n += str2x.charAt(i);
		}		
	}

		if (str1n.length() != str2n.length()) {
		return false;
		}else {
			int j = 0;
			while(str2n.length() > 0 && j < str2n.length()) {
				if (str2n.indexOf(str1n.charAt(j)) == -1) {
					return false ;
				} else {
					str2n = str2n.substring(0, j) + str2n.substring(j + 1);

				} j++;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		String str1 = "";
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || str.charAt(i) == ' ') {
				str1 = str1 + str.charAt(i); 

			}
		}
		return str1;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String str1 = preProcess(str);
		String str2 = "";
		int random=0;
		while (str1.length() > 0){
		 random = (int) (Math.random() * str1.length());
			str2 += str1.charAt(random);
			str1 = str1.substring(0, random) + str1.substring(random + 1);
		}
		return str2;
	}
}
