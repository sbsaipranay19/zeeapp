import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Manager extends Employee {
	private String projectName;
	private float projectAllowance;
	
	public Manager(String empId, String empName, String address, float salary) {
		super(empId,empName,address,salary);
	}
	
	public Manager() {
		this("ab001","abhi","hyd",10000.0f);
	}
	
	public Manager(String projectName, float projectAllowance) {
		this("ab001","abhi","hyd",10000.0f);
		this.projectName = projectName;
		this.projectAllowance = projectAllowance;
	}
	@Override
	public float calculateSalary() {
		// TODO Auto-generated method stub
		return super.calculateSalary()+projectAllowance;
	}
}
