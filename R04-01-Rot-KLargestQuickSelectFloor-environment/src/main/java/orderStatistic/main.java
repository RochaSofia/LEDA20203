package orderStatistic;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer [] entrada = {1,2,3,4,5,6};
        Integer [] entrada2 = {6,5,4,3,2,1,0};
        Integer [] entrada3 = {1,7,9,2,3,4,5,6,10};

        QuickSelect quick = new QuickSelect <Integer>();
        System.out.println(quick.quickSelect(entrada3,5));
	}

}
