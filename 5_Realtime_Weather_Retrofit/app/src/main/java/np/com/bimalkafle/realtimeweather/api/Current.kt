package np.com.bimalkafle.realtimeweather.api

data class Current(
    val cloud: String,
    val condition: Condition,
    val feelslike_c: String,
    val feelslike_f: String,
    val gust_kph: String,
    val gust_mph: String,
    val humidity: String,
    val is_day: String,
    val last_updated: String,
    val last_updated_epoch: String,
    val precip_in: String,
    val precip_mm: String,
    val pressure_in: String,
    val pressure_mb: String,
    val temp_c: String,
    val temp_f: String,
    val uv: String,
    val vis_km: String,
    val vis_miles: String,
    val wind_degree: String,
    val wind_dir: String,
    val wind_kph: String,
    val wind_mph: String
)