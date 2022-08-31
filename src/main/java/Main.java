import dto.ArticleSaveDto;
import dto.UpdatArticleAbject;
import repository.ArticleRepository;
import repository.UserRepository;
import view.UserView;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static String staticUsername;
    private static UserView userView = new UserView();

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int chosenOption = menu(scanner);
        switch (chosenOption){
            case 1:
                userView.signInOperation();
                break;
            case 2:
                signUpMethod(scanner);
                break;
            case 3:
                showAllArticlesToPeople();
                break;
            case  4:
//                todo: handel 4
                break;
            default:
                System.out.println( "the entered number is invalid");
        }
    }

    private static void signUpMethod(Scanner scanner) throws SQLException {
        System.out.println("pleas enter \n your username :");
        String username= scanner.next();
        System.out.println("and your password ");
        String password= scanner.next();

        if (passwordIsCorrected(username,password)){
            staticUsername=username;
            getSignUpMethod(scanner);
        }else {
            System.out.println("your password or username is wrong");
        }
    }

    private static void showAllArticlesToPeople() throws SQLException {
        ArticleRepository articleRepository = new ArticleRepository();
        articleRepository.showAllArticles();
    }

    private static boolean passwordIsCorrected(String username, String password) throws SQLException {
        UserRepository user=new UserRepository();
        boolean result =user.checkPassword(username,password);
        if (result) {
            return true;
        }
        return false;
    }

    private static void getSignUpMethod(Scanner scanner) throws SQLException {
        int id=getId(staticUsername);
        System.out.println("Dear user! \n pleas enter your option " +
                "\n 1 : enter new article " +
                "\n 2 : view your articles " +
                "\n 3 : update your articles " +
                "\n 4 : update your password ");
        int chosenOption=scanner.nextInt();
        switch (chosenOption){
            case 1:
                insertNewArticleMethod(scanner, id);
                break;
            case 2:
                viewUsersArticles(id);
                break;
            case 3:
                updateMethod(scanner);
            case 4:
                updatePasswordMethod(scanner, id);
        }
    }

    private static void updatePasswordMethod(Scanner scanner, int id) throws SQLException {
        System.out.println("enter new password: ");
        String newPassword= scanner.next();
        UserRepository userRepository = new UserRepository();
        userRepository.savedNewPassword(id,newPassword);
    }

    private static void updateMethod(Scanner scanner) throws SQLException {
        System.out.println("enter the name of the article you want to update: ");
        String oldTitle= scanner.next();
        System.out.println("which option do you want to update? " +
                "\n enter 1 for update article information \t and enter 2 for update published :");
        int chosenOptionForUpdate= scanner.nextInt();
        switch (chosenOptionForUpdate){
            case 1:
                updateArticleInformationMethod(scanner, oldTitle);
            case 2:
                updatePublishedMethod(scanner, oldTitle);

        }
    }

    private static void updatePublishedMethod(Scanner scanner, String oldTitle) throws SQLException {
        System.out.println("Will the article be published? please type yes or no : ");
        String publishedOrNot= scanner.next();
        boolean isPublished= getBooleanForIsPublished(publishedOrNot);
        ArticleRepository articleRepository = new ArticleRepository();
        String result=articleRepository.updatePublished(oldTitle,isPublished);
    }

    private static void updateArticleInformationMethod(Scanner scanner, String oldTitle) throws SQLException {
        System.out.println("update information :" +
                "\nnew title : ");
        String newTitle= scanner.next();
        System.out.println("new brief : ");
        String newBrief= scanner.next();
        System.out.println("new contents : ");
        String newContents= scanner.next();
        System.out.println("new date (for example 31/12/1998 ): ");
        String newDate= scanner.next();
        Date newArticleDate=userView.giveAndHandelDate(newDate);
        UpdatArticleAbject updatArticleAbject = new UpdatArticleAbject(newTitle, newBrief, newContents, newArticleDate);
        ArticleRepository articleRepository = new ArticleRepository();
        String result=articleRepository.updateArticle(oldTitle,updatArticleAbject);
        System.out.println(result);
    }

    private static void viewUsersArticles(int id) throws SQLException {
        ArticleRepository articleRepository = new ArticleRepository();
        articleRepository.articleListOfUser(id);
    }

    private static void insertNewArticleMethod(Scanner scanner, int id) throws SQLException {
        System.out.println("for insert new article , you most enter \n article title : ");
        String title= scanner.next();
        System.out.println("brief of article :");
        String brief= scanner.next();
        System.out.println("content : ");
        String content= scanner.next();
        System.out.println("create date (for example 31/12/1998 ): ");
        String date= scanner.next();
        Date articleDate=userView.giveAndHandelDate(date);
        System.out.println("Will the article be published? please type yes or no : ");
        String publishedOrNot= scanner.next();
        boolean isPublished= getBooleanForIsPublished(publishedOrNot);//in database is null
        ArticleSaveDto articleSaveDto = new ArticleSaveDto(title, brief, content, articleDate, isPublished, id);
        String result=new ArticleRepository().insertNewArticle(articleSaveDto);
        System.out.println(result);
    }

    private static boolean getBooleanForIsPublished(String publishedOrNot) {
        if (publishedOrNot.equals("yse")){
            return true;
        }
        return false;
    }

    private static int getId(String staticUsername) throws SQLException {
        UserRepository userRepository = new UserRepository();
       return  userRepository.getIdByUsername(staticUsername);
    }

    private static int menu(Scanner scanner) {
        System.out.println("Dear user ! \n please enter your option " +
                "\n 1: sign in " +
                "\n 2: sign up" +
                "\n 3: see articles" +
                "\n 4: exist ");
        int chosenOption = scanner.nextInt();
        return chosenOption;
    }

}
