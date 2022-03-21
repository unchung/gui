import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    Container contentPane;
    private JButton clickButton;
    private JPanel panel1;
    private JButton button1;
    JLabel imageLabel = new JLabel();

    Font font = new Font("Aharoni 굵게", Font.BOLD, 15);

    App(){
        setTitle("Menu와 JFileChooser 활용 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        contentPane.add(imageLabel);
        createMenu();
        createMain();
        setSize(300,200);
        setVisible(true);
    }

    void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");

        // Open 메뉴아이템에 Action 리스너를 등록한다.
        openItem.addActionListener(new OpenActionListener());
        fileMenu.add(openItem);
        mb.add(fileMenu);

        this.setJMenuBar(mb);
    }

    void createMain(){
        JPanel mb = new JPanel();
        mb.add(panel1);
        //System.out.println("통과함");
    }

    // Open 메뉴아이템이 선택되면 호출되는 Action 리스너
    class OpenActionListener implements ActionListener {
        JFileChooser chooser;

        OpenActionListener() {
            chooser= new JFileChooser(); // 파일 다이얼로그 생성
        }
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "HWP", // 파일 이름에 창에 출력될 문자열
                    "hwp"); // 파일 필터로 사용되는 확장자. *.jpg. *.gif만 나열됨
            chooser.setFileFilter(filter); // 파일 다이얼로그에 파일 필터 설정

            // 파일 다이얼로그 출력
            int ret = chooser.showOpenDialog(null);
            if(ret != JFileChooser.APPROVE_OPTION) { // 사용자가  창을 강제로 닫았거나 취소 버튼을 누른 경우
                JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다", "경고",

                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
            String filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
            String fileName = chooser.getSelectedFile().getName();
            //imageLabel.setIcon(new ImageIcon(filePath)); // 파일을 로딩하여 이미지 레이블에 출력한다.
            imageLabel.setText(fileName);
            imageLabel.setFont(font);

            //pack(); // 이미지의 크기에 맞추어 프레임의 크기 조절
        }
    }


}
