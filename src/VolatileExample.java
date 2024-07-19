public class VolatileExample {

    private boolean status = true;
    public static void main(String[] args) {
        
        VolatileExample ve = new VolatileExample();

        Thread thread = new Thread(() -> {
            try{

                Thread.sleep(3000);
    
            }catch(InterruptedException ex){
    
                ex.printStackTrace();
                
            }
            if(ve.status){


                System.out.println("Doing some work....");
            }
            System.out.println("Thread Name : " + Thread.currentThread().getName());
        });

        thread.start();

        try{

            Thread.sleep(2000);

        }catch(InterruptedException ex){

            ex.printStackTrace();
            
        }

        ve.status = false;

        try{

            thread.join();

        }catch(InterruptedException ex){

            ex.printStackTrace();

        }



    }
    
}
