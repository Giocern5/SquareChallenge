package employeefeed

import Model.Employee
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import api.EmployeeService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class EmployeeViewModel: ViewModel() {
    private var list = MutableLiveData<List<Employee>>()
    private var employeeService = Retrofit.Builder()
                                    .baseUrl("https://s3.amazonaws.com/")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build()
                                    .create(EmployeeService::class.java)

    fun getEmployeesList():MutableLiveData<List<Employee>> {

        viewModelScope.launch {
            try {
                val response = employeeService.getEmployees().awaitResponse()
                if(response.isSuccessful) {
                    Log.v("api call", "refresh hitt")
                    var employeeList = response.body()?.employees ?: emptyList()
                    if(!Utils.Utils.validateList(employeeList)) {
                        employeeList = emptyList()
                    }
                    list.postValue(employeeList)
                }
            } catch (e: Exception) {
               e.printStackTrace()
            }
        }

        return list
    }
}