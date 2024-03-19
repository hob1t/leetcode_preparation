package msit_5214;

public class RabinKarp {
	private final static int d = 10;

	static void search(String pattern, String txt, int q) {
		int m = pattern.length();
		int n = txt.length();
		int i, j;
		int p = 0;
		int t = 0;
		int h = 1;

		for (i = 0; i < m - 1; i++) {
			h = (h * d) % q;
			System.out.print(h + ", i=" + i + " ");
		}
		System.out.println();

		// Calculate hash value for pattern and text
		for (i = 0; i < m; i++) {
			p = (d * p + pattern.charAt(i)) % q;
			t = (d * t + txt.charAt(i)) % q;
		}

		// Find the match
		for (i = 0; i <= n - m; i++) {
			if (p == t) {
				for (j = 0; j < m; j++) {
					if (txt.charAt(i + j) != pattern.charAt(j)) {
						break;
					}
				}

				if (j == m) {
					System.out.println(String.format("h(P)=%d, h(T)=%d", p, t));
					System.out.println("Pattern is found at position: " + (i + 1));
				}
			}

			if (i < n - m) {
				t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
				if (t < 0) {
					t = (t + q);
				}
			}
		}
	}

	public static void main(String[] args) {
	    String txt = "AABAACAADAABAAABAA";
	    String pattern = "AABA";
	    int q = 20;
	    search(pattern, txt, q);
	}
}
