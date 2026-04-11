/*
 * 3474. Lexicographically Smallest Generated String
 */

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char arr[] = new char[n + m - 1];
        int fixed[] = new int[n + m - 1];

        for (int i = 0; i < n + m - 1; i++) {
            arr[i] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = i; j < i + m; j++) {
                    if (fixed[j] == 1 && arr[j] != str2.charAt(j - i)) {
                        return "";
                    } else {
                        arr[j] = str2.charAt(j - i);
                        fixed[j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean flag = false;
                int idx = -1;

                for (int j = i + m - 1; j >= i; j--) {
                    if (arr[j] != str2.charAt(j - i)) {
                        flag = true;
                    }
                    if (idx == -1 && fixed[j] == 0) {
                        idx = j;
                    }
                }

                if (flag) {
                    continue;
                } else if (idx != -1) {
                    arr[idx] = 'b';
                } else {
                    return "";
                }
            }
        }

        return new String(arr);

    }
}