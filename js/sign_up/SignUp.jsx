import { useRef, useState } from "react"
import Entry from "../common/Entry.jsx"

export default function SignUp(props) {
  return <Entry formType="login" form={<SignUpForm />} />
}

function SignUpForm() {
  const [data, setData] = useState({
    email: "", 
    userName: "",
    fullName: "",
    password: "",
    confirmPassword: "",
  })

  const passwordRef = useRef(null)
  const confirmPasswordRef = useRef(null)
  const matchMessage = useRef(null)

  const handlePasswordChange = (e) => {
    const passwordVal = passwordRef.current.value;
    const confirmPasswordVal = confirmPasswordRef.current.value;

    setData((prevData) => ({
        ...prevData,
        password: passwordVal,
        confirmPassword: confirmPasswordVal,
    }))

    matchMessage.current.innerText = passwordVal === confirmPasswordVal ?  "" : "password don't match";
  }
  
  return (
    <form className="form" action="">
        <div className="input-group">
        <label>Email: </label>
        <input name="email" id="email-input" placeholder="doctor.giggle.touch@gmail.com" />
      </div>

      <div className="input-group">
        <label>Username: </label>
        <input name="username" id="username-input" placeholder="ProfessorHankySpanky" />
      </div>
      
      <div className="input-group">
        <label>Full Name: </label>
        <input name="fullName" id="full-name-input" placeholder="Doodle Wacker" />
      </div>

      <div className="input-group">
        <label>Password: </label>
        <input name="password" id="password-input" placeholder="" ref={passwordRef} onChange={handlePasswordChange} />
      </div>

      <div className="input-group">
        <label>Confirm Password: 
          <div className="password-match" ref={matchMessage}></div>
        </label>
        <input name="confirmPassword" id="confirm-password-input" placeholder="" ref={confirmPasswordRef} onChange={handlePasswordChange} />
      </div>

      <button type="submit">SIGNUP</button>
    </form>
  )
}