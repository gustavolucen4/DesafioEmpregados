package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner keyBoard = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String departmentName = keyBoard.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = keyBoard.nextInt();
		System.out.print("Email: ");
		String email = keyBoard.next();
		System.out.print("Telefone: ");
		String phone = keyBoard.next();
		
		Department department = new Department(departmentName, payDay, new Address(email, phone));
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int numberEmployee = keyBoard.nextInt();
		for(int i = 1; i <= numberEmployee; i++) {
			System.out.print("Dados do funcionário "+ i +": ");
			keyBoard.nextLine();
			String employeeName = keyBoard.nextLine();
			System.out.print("Salário: ");
			double salary = keyBoard.nextDouble();
			
			department.addEmployee(new Employee(employeeName, salary));
		}
		
		System.out.println("");
		showReport(department);
		
		keyBoard.close();
	}
	
	private static void showReport(Department dept) {
		// MOSTRAR NA TELA OS DADOS DO RELATÓRIO
		StringBuilder paperPay = new StringBuilder();
		paperPay.append("FOLHA DE PAGAMENTO: \n");
		paperPay.append("Departamento Vendas = R$ ");
		paperPay.append(String.format("%.2f \n", dept.payroll()));
		paperPay.append("Pagamento realizado no dia ");
		paperPay.append(dept.getPayDay() + 	"\n");
		paperPay.append("Funcionários:\n");
		for (Employee employee  : dept.getEmployees()) {
			paperPay.append(employee.getName() + "\n");
		}
		paperPay.append("Para dúvidas favor entrar em contato: ");
		paperPay.append(dept.getAddress().getEmail());
		
		System.out.println(paperPay.toString());
		}
}
