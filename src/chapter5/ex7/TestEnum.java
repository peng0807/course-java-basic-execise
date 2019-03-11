package chapter5.ex7;

///说明：这是一个模拟交通信号灯的程序
enum TrafficSignal { // 定义表示交通信号的枚举类 TrafficSignal
	GREEN(7) { // 定义枚举常量：GREEN，表示绿灯，持续时间7秒
		@Override
		public TrafficSignal nextSignal() { // 绿灯过后是红灯
			return YELLOW;
		}
	}, // 注意：这里是逗号“,” 不是分号
	YELLOW(2) { // 定义枚举常量：YELLOW，表示黄灯，持续时间是2秒，黄灯过后是红灯
		@Override
		public TrafficSignal nextSignal() {
			return RED;
		}
	},
	RED(5) {
		@Override
		public TrafficSignal nextSignal() {
			return GREEN;
		}
	}; // 注意：这里是分号“;” 不是逗号
	private int duration; // 私有成员变量，表示交通灯持续的时间
	// 定义TrafficSignal的构造方法，提供int类型参数以初始化成员变量duration

	private TrafficSignal(int duration) {
		this.duration = duration;
	}

	// 定义公共的getDuration方法，以返回成员变量duration
	public int getDuration() {
		return this.duration;
	}

	public abstract TrafficSignal nextSignal(); // 声明的抽象方法，返回下一个交通信号灯
}

public class TestEnum {
	public static void main(String[] args) throws Exception {
		System.out.println("打印出所有的交通信号灯：");
		TrafficSignal[] lights = TrafficSignal.values(); // 使用TrafficSignal类的静态方法values，以获得所有枚举常量组成的数组
		for (TrafficSignal light : lights) {
			System.out.println(light.ordinal() + ":" + light.name());
		}
		System.out.println("模拟交通信号灯的变化过程：");
		TrafficSignal light = TrafficSignal.GREEN; // 创建枚举对象：绿色的交通信号灯
		for (int i = 0; i < 7; i++) {
			System.out.println(light);
			Thread.sleep(1000 * light.getDuration()); // 程序会暂停1000*duration毫秒
			light = light.nextSignal(); // 切换到下一个交通信号灯
		}
	}
}