package view;

import dto.UserSaveDto;
import repository.UserRepository;
import util.DateUtil;

import java.util.Date;
import java.util.Scanner;

public class UserView {
    private UserRepository userRepository = new UserRepository();
    private Scanner scanner = new Scanner(System.in);


    public void signInOperation() {
        Date birthDay;
        String username;
        String birthday;
        String nationalCode;
        System.out.println("dear user ! for sign in , pleas enter ;" +
                "\n your username : ");
        username= scanner.next();
        System.out.println("your national code : ");
        nationalCode= scanner.next();
        System.out.println("your birthday (for example 31/12/1998 ) : ");
        birthday= scanner.next();
        birthDay=giveAndHandelDate(birthday);
        UserSaveDto dto = new UserSaveDto(username, nationalCode, birthDay);
        String result = userRepository.save(dto);
        System.out.println(result);
    }

    public Date giveAndHandelDate(String birthday) {
        Date date;
        try {
            date = DateUtil.parse(birthday);
            System.out.println(date);
        } catch (RuntimeException e) {
            System.out.println("your input date is wrong ! pleas pay attention to the pattern");
            throw new RuntimeException(e);
        }
        return  date;
    }
}
