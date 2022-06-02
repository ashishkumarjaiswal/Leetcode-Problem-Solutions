class Solution {
    public String validIPAddress(String queryIP) {
        String[] arr = queryIP.split("\\.");

        if (arr.length == 4) {
            if (queryIP.charAt(queryIP.length() - 1) == '.')
                return "Neither";

            for (int i = 0; i < 4; i++) {
                String s = arr[i];
                try {
                    if (s.length() > 1 && s.charAt(0) == '0') {
                        return "Neither";
                    }

                    int x = Integer.parseInt(s);
                    if (x >= 0 && x <= 255) {
                        continue;
                    } else {
                        return "Neither";
                    }
                } catch (Exception e) {
                    return "Neither";
                }
            }

            return "IPv4";
        } else {
            String[] ip = queryIP.split(":");

            if (ip.length != 8 || queryIP.charAt(queryIP.length() - 1) == ':') {
                System.out.println("1");
                return "Neither";
            }

            for (int i = 0; i < 8; i++) {
                String s = ip[i];

                if (s.length() >= 1 && s.length() <= 4) {
                    for (int j = 0; j < s.length(); j++) {
                        int c = s.charAt(j);

                        if ((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9')) {
                            continue;
                        } else {
                            System.out.println(i + "2");
                            return "Neither";
                        }
                    }
                } else {
                    System.out.println("3");
                    return "Neither";
                }
            }

            return "IPv6";
        }
    }
}
