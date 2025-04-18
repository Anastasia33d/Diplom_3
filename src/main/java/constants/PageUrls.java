package constants;
public class PageUrls {
        public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

        public static class Auth {
                public static final String REGISTER = BASE_URL + "/register";
                public static final String LOGIN = BASE_URL + "/login";
                public static final String FORGOT_PASSWORD = BASE_URL + "/forgot-password";
        }

        public static class Profile {
                public static final String PROFILE = BASE_URL + "/account/profile";
        }

        public static class Main {
                public static final String MAIN = BASE_URL + "/";
        }
}