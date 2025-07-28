import './App.css';
import { Routes, Route } from "react-router-dom";
import Create from './components/Create';
import Navbar from './components/Navbar';
import Edit from './components/Edit';
import ViewAllJobs from './components/ViewAllJobs';
import Register from './components/Register';
import RegistrationSuccess from './components/RegistrationSuccess';
import Login from './components/Login';
import AuthProvider from './AuthProvider'
import ProtectedRoute from './components/ProtectedRoute';

function App() {
  return (
  <AuthProvider>
   <Navbar/>
   <Routes>
   <Route path='/' element={<ProtectedRoute><ViewAllJobs /></ProtectedRoute>}/>
   <Route path="/create" element={<ProtectedRoute><Create /></ProtectedRoute>} />
   <Route path="/edit" element={<ProtectedRoute><Edit /></ProtectedRoute>} />
   <Route path="/register" element={<Register />} />
   <Route path="/registrationSuccess" element={<ProtectedRoute><RegistrationSuccess /></ProtectedRoute>} />
   <Route path="/login" element={<Login />} />
   </Routes>
  </AuthProvider>
  );
}

export default App;