package api
import Model.Employees
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeService {
    @GET("sq-mobile-interview/employees.json")
    fun getEmployees(): Call<Employees>
}