package mx.tec.lab;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SuppressWarnings("serial")
@SpringBootApplication
public class TestSwingApplication extends JFrame {
	protected JLabel numberOneLabel;
	protected JLabel numberTwoLabel;
	protected JLabel resultLabel;
	protected JTextField numberOneTextField;
	protected JTextField numberTwoTextField;
	protected JButton operationButton;
	protected JTextField resultTextField;
	
	public TestSwingApplication() {
		super("Swing Example");
		initUI();
		createLayout();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(TestSwingApplication.class).headless(false).run(args);
		
		EventQueue.invokeLater(() -> {
			TestSwingApplication application = context.getBean(TestSwingApplication.class);
			
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			application.setSize(500, 100);
			application.setVisible(true);
		});
	}
	
	private void initUI() {
		numberOneLabel = new JLabel("Number 1");
		numberTwoLabel = new JLabel("Number 2");
		resultLabel = new JLabel("Result:", JLabel.CENTER);
		numberOneTextField = new JTextField(5);
		numberTwoTextField = new JTextField(5);
		resultTextField = new JTextField(5);
		resultTextField.setEditable(false);
		operationButton = new JButton("sum");
		operationButton.addActionListener(e -> {
			int a = Integer.parseInt(numberOneTextField.getText());
			int b = Integer.parseInt(numberTwoTextField.getText());
			int c = a + b;resultTextField.setText(String.valueOf(c));
		});
	}
	
	private void createLayout() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(numberOneLabel);
		container.add(numberOneTextField);
		container.add(numberTwoLabel);
		container.add(numberTwoTextField);
		container.add(operationButton);
		container.add(resultLabel);
		container.add(resultTextField);
	}

}
