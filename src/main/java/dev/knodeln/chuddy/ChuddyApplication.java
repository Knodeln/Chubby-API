package dev.knodeln.chuddy;

// import javax.swing.JFrame;
// import javax.swing.SwingUtilities;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import dev.knodeln.chuddy.controller.CalendarController;
// import dev.knodeln.chuddy.model.CalendarModel;
// import dev.knodeln.chuddy.view.CalendarView;
// import org.springframework.context.ConfigurableApplicationContext;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication
// public class ChuddyApplication {

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             CalendarModel model = new CalendarModel();
//             CalendarView view = new CalendarView(model);

//             JFrame frame = new JFrame("Calendar App");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             frame.getContentPane().add(view);
//             frame.setSize(500, 500);
//             frame.setLocationRelativeTo(null);
//             frame.setVisible(true);
//         });
// 	}
// }

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChuddyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChuddyApplication.class, args);
    }
}
 