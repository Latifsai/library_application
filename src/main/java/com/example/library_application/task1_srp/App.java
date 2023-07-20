package students.LatifSait.extraHwPro.task1_srp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import students.LatifSait.extraHwPro.task1_srp.config.BookListConfiguration;
import students.LatifSait.extraHwPro.task1_srp.console.ProgramMenu;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = createContext();

        ProgramMenu menu = context.getBean(ProgramMenu.class);
        while (true) {
            menu.print();
            int select = menu.controller();
            menu.executeSelectedMenuItem(select);

            if (select == 6){
                break;
            }
        }
    }

    private static ApplicationContext createContext() {
        return new AnnotationConfigApplicationContext(BookListConfiguration.class);
    }

}
