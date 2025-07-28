import {
  AppBar,
  Toolbar,
  Box,
  Grid,
  Typography,
  Button,
} from "@mui/material";
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../AuthContext';
import axiosInstance from '../axiosConfig';


const Navbar = () => {
  const navigate = useNavigate();
  const { isAuthenticated, logout } = useAuth();
  const handleLogout = () => {
    logout();
    axiosInstance.post('http://localhost:8080/logout');
    navigate('/login');
  }
  return (
    <Grid container spacing={2} sx={{ margin: "2%" }}>
  <Grid item xs={12}>
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static" style={{ background: '#ADD8E6' }}>
        <Toolbar variant="dense">
          <Typography variant="h4" align='left' component="div" sx={{ flexGrow: 1, fontFamily: "revert", fontSize: "500", color: "black" }}>
            Job Portal
          </Typography>
          <Box sx={{ m: 0.5, mx: 'auto', width: 80 }}>
            <Button variant="outlined" onClick={() => { navigate('/') }}>Home</Button>
          </Box>
          <Box sx={{ m: 0.5, mx: 'auto', width: 100 }}>
            <Button variant="outlined" onClick={() => { navigate('/create') }}>Add Job</Button>
          </Box>
          <Box sx={{ m: 0.5, mx: 'auto', width: 180 }}>
            <Button variant="outlined" href='https://www.linkedin.com/in/aryanshrivastav2005/'>Contact Us</Button>
          </Box>
          <Box sx={{ width: 180 }}>
            <Button variant="outlined" onClick={() => { navigate('/register') }}>Register</Button>
          </Box>
          <Box sx={{ width: 180 }}>
            {isAuthenticated ?
              (<Button variant="outlined" onClick={handleLogout}>Log out</Button>)
              : (<Button variant="outlined" onClick={() => { navigate('/login') }}>Login</Button>
              )}
          </Box>
        </Toolbar>
      </AppBar>
    </Box>
  </Grid>
</Grid>

  )
}

export default Navbar