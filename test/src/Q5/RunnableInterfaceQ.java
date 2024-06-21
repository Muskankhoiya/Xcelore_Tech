package Q5;

public class RunnableInterfaceQ {
    public static void main(String[] args){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    System.out.println(i);
                }

            }
        });

        thread.run();
    }
}

