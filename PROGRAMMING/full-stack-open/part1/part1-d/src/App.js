import { useState } from 'react'

const Header = () => {

  return (
  <h1>give feedback</h1>
  )
}

const StatisticsHeader = () => {

  return (
  <h1>statistics</h1>
  )
}

const Button = (props) => {
  return (
    <button onClick={props.handleClick}>
      {props.text}
    </button>
  )
}

const StatisticLine = (props) => {
  return (
    <tr><td>{props.text}</td><td>{props.value}</td></tr>
  )
}

const App = () => {
  // save clicks of each button to its own state
  const [good, setGood] = useState(0)
  const [neutral, setNeutral] = useState(0)
  const [bad, setBad] = useState(0)
  const [total, setTotal] = useState(0)
  const [score, setScore] = useState(0)

  const handleGoodClick = () => {
    setGood(good + 1)
    setTotal(total + 1)
    setScore(score + 1)
  }

  const handleNeutralClick = () => {
    setNeutral(neutral + 1)
    setTotal(total + 1)
  }

  const handleBadClick = () => {
    setBad(bad + 1)
    setTotal(total + 1)
    setScore(score - 1)
  }

  const Statistics = (props) => {

    if (props.total === 0) {
      return (
        <div>
          No feedback given
        </div>
      )
    }

    return (
      <>
        <StatisticsHeader/>
        <table>
          <tbody>
          <StatisticLine value={good} text='good' />
          <StatisticLine value={neutral} text='neutral'/>
          <StatisticLine value={bad} text='bad'/>
          <StatisticLine value={total} text='all'/>
          <StatisticLine value={score / total} text='average'/>
          <StatisticLine value={good / total} text='positive'/>
          </tbody>
        </table>
      </>
    )
  }

  return (
    
    <div>
      <Header/>
      <Button handleClick={handleGoodClick} text='good' />
      <Button handleClick={handleNeutralClick} text='neutral' />
      <Button handleClick={handleBadClick} text='bad' />
      <Statistics total={total}/>
      
    </div>
  )
}

export default App
