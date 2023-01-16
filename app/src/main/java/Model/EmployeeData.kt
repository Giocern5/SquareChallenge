package Model

enum class EmployeeType {
    FULL_TIME, PART_TIME, CONTRACTOR
}
data class Employee(
    val uuid: String,
    val full_name: String,
    val phone_number: String?,
    val email_address: String,
    val biography: String?,
    val photo_url_small: String?,
    val photo_url_large: String?,
    val team: String,
    val employee_type: EmployeeType,
)

data class Employees(
    val employees: List<Employee>
)