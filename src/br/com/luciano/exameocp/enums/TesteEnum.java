package br.com.luciano.enums;

public class TesteEnum {
	
	private Day day;
	
	public TesteEnum(Day day) {
		this.day = day;
	}
	
	public void findByDay() {
		switch(day) {
			case MONDAY:
				System.out.println(Day.MONDAY.getDescricao());
				break;
			case TUESDAY:
				System.out.println(Day.THUSDAY.getDescricao());
				break;
			case WEDNESDAY:
				System.out.println(Day.WEDNESDAY.getDescricao());
				break;
			case THUSDAY:
				System.out.println(Day.THUSDAY.getDescricao());
				break;
			case FRIDAY:
				System.out.println(Day.FRIDAY.getDescricao());
				break;
			case SANTUDAY:
				System.out.println(Day.SANTUDAY.getDescricao());
				break;
			case SANDY:
				System.out.println(Day.SANDY.getDescricao());
				break;
//			default: 
//				System.out.println("Não existe esse dia");
		}
	}

	public static void main(String[] args) {
		Day day = Day.FRIDAY;
		
		TesteEnum t1 = new TesteEnum(day);
		t1.findByDay();

	}

}
