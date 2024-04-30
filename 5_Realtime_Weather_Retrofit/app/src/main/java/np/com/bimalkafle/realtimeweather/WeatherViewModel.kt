package np.com.bimalkafle.realtimeweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.bimalkafle.realtimeweather.api.Constant
import np.com.bimalkafle.realtimeweather.api.NetworkResponse
import np.com.bimalkafle.realtimeweather.api.RetrofitInstance
import np.com.bimalkafle.realtimeweather.api.WeatherModel

class WeatherViewModel :ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult : LiveData<NetworkResponse<WeatherModel>> = _weatherResult



    fun getData(city : String){
        _weatherResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try{
                val response = weatherApi.getWeather(Constant.apiKey,city)
                if(response.isSuccessful){
                    response.body()?.let {
                        _weatherResult.value = NetworkResponse.Success(it)
                    }
                }else{
                    _weatherResult.value = NetworkResponse.Error("Failed to load data")
                }
            }
            catch (e : Exception){
                _weatherResult.value = NetworkResponse.Error("Failed to load data")
            }

        }
    }

}












