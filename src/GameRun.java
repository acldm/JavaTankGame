import javax.swing.*;
import java.awt.*;
import Main.GMain;
import Util.Config;

/**
 * 运行要求: 由于部分代码使用到了 lambda表达式 以及 流操作
 * 需要JDK1.8及以上版本才能正常运行
 * */
public class GameRun extends JFrame{

	public GameRun() {
		Container contentPane = this.getContentPane();

		this.setLayout(null);
		this.setTitle(Config.Title);
		setSize(Config.WindowWidth, Config.WindowHeight);
		setResizable(false);
		setBackground(Config.BackGround);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GMain m = new GMain();
		contentPane.add(m, BorderLayout.CENTER);

		m.setLocation(32, 32);
	}

	public static void main(String[] args) {
		new GameRun().setVisible(true);
	}

}
