const Header = (props) => {
  return (
      <h1>{props.course}</h1>
  )
  
}

const Part = (props) => {
  console.log(props)
  return (
      <p>
        {props.part} {props.exercises}
      </p>
    )  
  
  }


const Total = (props) => {
  console.log(props.parts[0])
  return (
      <p>
        Number of exercises {props.parts[0].exercises + props.parts[1].exercises + props.parts[2].exercises }
      </p>
  )  

}

const App = () => {
  const course = {
    name: 'Half Stack application development',
    parts: [
      {
        name: 'Fundamentals of React',
        exercises: 10
      },
      {
        name: 'Using props to pass data',
        exercises: 7
      },
      {
        name: 'State of a component',
        exercises: 14
      }
    ]
  }

  const  Content = (props) => {
    return (
        <div>
          <Part part={course.parts[0].name} exercises={course.parts[0].exercises} />
          <Part part={course.parts[1].name} exercises={course.parts[1].exercises} />
          <Part part={course.parts[2].name} exercises={course.parts[2].exercises} />
        </div>
      )  
    
    }
  
  
  return (
    <div>
      <Header course={course.name} />
      <Content parts={course.parts}/>
      <Total parts={course.parts} />
    </div>
  )
}

export default App