package Utils

import Model.Employee

object Utils {
    fun validateList(employeeList: List<Employee>): Boolean {
        for (employee in employeeList) {
            if (employee.uuid == null
                || employee.full_name == null
                || employee.email_address == null
                || employee.team == null
                || employee.employee_type == null
            ) {
                return false
            }
        }

        return true
    }
}

// Unit tests didnt seem to work but here is an example case to unit test this

//import Model.Employee
//import Model.EmployeeType
//import junit.framework.Assert
//import org.junit.Assert.*
//
//import org.junit.Test
//
//class UtilsTest {
//
//    val testEmployee =  Employee(uuid = "some-uuid",
//        full_name = "Eric Rogers",
//        phone_number = "5556669870",
//        email_address = "erogers.demo@squareup.com",
//        biography = "Hello",
//        photo_url_small = "https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/small.jpg",
//        photo_url_large = "https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/large.jpg",
//        team = "Seller",
//        employee_type = EmployeeType.FULL_TIME)
//
//    val employeeTestList: List<Employee> = arrayListOf(
//        testEmployee, testEmployee, testEmployee)
//    @Test
//    fun validateList() {
//        assertEquals(Utils.validateList(emptyList()), true)
//        assertEquals(Utils.validateList(employeeTestList), true)
//    }
//}