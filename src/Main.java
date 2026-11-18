import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;


void main() throws InterruptedException, IOException {
    ArrayList<Service> ServiceList = new ArrayList<Service>();
    int Nbservice = 10;

    FileWriter fileWriter = new FileWriter("test.txt", false);

    for(int i=0; i<Nbservice; i++){
        Service S = new Service("Thread "+i);
        S.setFileWriter(fileWriter);
        ServiceList.add(S);
    }

    for(int i=0; i<Nbservice; i++){
        System.out.println(ServiceList.get(i));
    }

    for (Service s : ServiceList) {
        s.run();
    }

    for (Service s : ServiceList) {
        s.join();
    }

    fileWriter.close();

    System.out.println("Tous les services sont terminés");
}
