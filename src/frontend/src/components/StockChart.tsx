import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Line } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  LineElement,
  PointElement,
  CategoryScale,
  LinearScale,
  Legend,
  Tooltip,
} from 'chart.js';
import { StockResponseDto } from '../types/StockData';

ChartJS.register(LineElement, PointElement, CategoryScale, LinearScale, Legend, Tooltip);

const StockChart: React.FC = () => {
  const [symbol, setSymbol] = useState('005930'); // 기본: 삼성전자
  const [days, setDays] = useState(5);
  const [data, setData] = useState<StockResponseDto[]>([]);
  const [chartData, setChartData] = useState<any>(null);

  const fetchData = () => {
    axios
      .get<StockResponseDto[]>('http://localhost:8080/api/stock', {
        params: { symbol, days },
      })
      .then((res) => {
        setData(res.data);
      })
      .catch((err) => {
        console.error('API 요청 실패:', err);
      });
  };

  useEffect(() => {
    fetchData(); // 처음 로딩 시
  }, []);

  useEffect(() => {
    if (data.length === 0) return;

    const labels = data.map((d) => d.date).reverse();
    const open = data.map((d) => d.open).reverse();
    const close = data.map((d) => d.close).reverse();
    const high = data.map((d) => d.high).reverse();
    const low = data.map((d) => d.low).reverse();

    setChartData({
      labels,
      datasets: [
        {
          label: '시가 (Open)',
          data: open,
          borderColor: 'blue',
          fill: false,
        },
        {
          label: '종가 (Close)',
          data: close,
          borderColor: 'green',
          fill: false,
        },
        {
          label: '고가 (High)',
          data: high,
          borderColor: 'red',
          fill: false,
        },
        {
          label: '저가 (Low)',
          data: low,
          borderColor: 'orange',
          fill: false,
        },
      ],
    });
  }, [data]);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    fetchData(); // 사용자가 submit할 때 새로운 요청
  };

  return (
    <div style={{ width: '800px', margin: '0 auto' }}>
      <h2>📈 종목 주가 차트</h2>

      <form onSubmit={handleSubmit} style={{ marginBottom: '1rem' }}>
        <label>
          종목 코드:
          <input
            type="text"
            value={symbol}
            onChange={(e) => setSymbol(e.target.value)}
            style={{ margin: '0 10px' }}
          />
        </label>

        <label>
          조회 일수:
          <select value={days} onChange={(e) => setDays(Number(e.target.value))}>
            <option value={5}>5일</option>
            <option value={10}>10일</option>
            <option value={20}>20일</option>
          </select>
        </label>

        <button type="submit" style={{ marginLeft: '10px' }}>조회</button>
      </form>

      {chartData ? (
        <Line data={chartData} />
      ) : (
        <p>차트 데이터를 불러오는 중...</p>
      )}
    </div>
  );
};

export default StockChart;
