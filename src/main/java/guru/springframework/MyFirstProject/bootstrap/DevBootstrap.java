package guru.springframework.MyFirstProject.bootstrap;

import guru.springframework.MyFirstProject.model.Client;
import guru.springframework.MyFirstProject.model.Employee;
import guru.springframework.MyFirstProject.repositories.ClientRepository;
import guru.springframework.MyFirstProject.repositories.EmployeeRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private EmployeeRepository employeeRepository;
    private ClientRepository clientRepository;

    public DevBootstrap(EmployeeRepository employeeRepository, ClientRepository clientRepository) {
        this.employeeRepository = employeeRepository;
        this.clientRepository = clientRepository;
    }

    private void initData(){
        Client client01=new Client("Alberto Cliente");
        Client client02=new Client("Juan Cliente");
        Client client03=new Client("Alfonso Cliente");
        Client client04=new Client("Nicanor Cliente");
        Client client05=new Client("Ricardo Cliente");
        clientRepository.save(client01);
        clientRepository.save(client02);
        clientRepository.save(client03);
        clientRepository.save(client04);
        clientRepository.save(client05);

        Employee employee01=new Employee("Ernesto Employee");
        Employee employee02=new Employee("Gonzalo Employee");
        employee01.addClient(client01);
        employee01.addClient(client02);
        employee02.addClient(client03);
        employee02.addClient(client04);
        employee02.addClient(client05);
        employeeRepository.save(employee01);
        employeeRepository.save(employee02);

    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initData();
    }
}
