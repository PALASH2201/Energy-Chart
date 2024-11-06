import React, { useState, useEffect } from "react";
import { BarChart } from "@mui/x-charts/BarChart";
import "./App.css";
import axios from "axios";
import data from "./assets/lightson.new_energySaving_interview_qn_1213.json";

const MyBarChart = () => {
  const [chartData, setChartData] = useState([]);
  const axiosInstance = axios.create({
    baseURL: "http://localhost:8080/energy",
    headers: {
      "Content-Type": "application/json",
    },
  });
  useEffect(() => {
    // const fetchData = () => {
    //   const formattedData = data.map((item) => ({
    //     x: new Date(item.createdAt.$date).toLocaleDateString(),
    //     y: item.total_kwh,
    //   }));
    //   setChartData(formattedData);
    // };
    // fetchData();

    const fetchDataFromDB = async () => {
      try{
          const response = await axiosInstance.get();
          //console.log(response.data);
          const formattedData = response.data.map((item) => ({
            x: new Date(item.createdAt).toLocaleDateString(), 
            y: item.total_kwh,
          }));          
          //console.log(formattedData);
          setChartData(formattedData);
      }catch(error){  
          console.error(error);
      }
    };

    fetchDataFromDB();
  }, []);

  return (
    <>
      {chartData.length > 0 ? (
        <div className="chart">
          <BarChart
            loading={chartData.length === 0}
            dataset={chartData}
            series={[
              {
                data: chartData.map((item) => item.y),
              },
            ]}
            xAxis={[
              {
                dataKey: "x",
                label: "Date Created",
                scaleType: "band",
              },
            ]}
            yAxis={[
              {
                dataKey: "y",
                label: "Total kWh",
              },
            ]}
            height={500}
            width={800}
          />
        </div>
      ) : (
        <div>Loading...</div>
      )}
    </>
  );
};

export default MyBarChart;
