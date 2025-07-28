import { Box, Button, Container, TextField, Typography } from "@mui/material";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../AuthContext";
import axiosInstance from "../axiosConfig";

function Login() {
    const [error, setError] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const {login} = useAuth();

    const handleLogin = async (e) =>{
        try {
            e.preventDefault();
            const response = await axiosInstance.post('http://localhost:8080/login', {username, password}, {
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            });
            console.log(response);
            if (response.status === 200)
            {
                login();
                navigate('/');
            }
            else
            {
                const errorText = await response.text();
                setError(errorText);
            }
        } catch (error) {
            if (error.response)
                setError(error.response.data || "Login Failed");
            else
                setError(error.message);
        }
    }

    return (
        <>
            <Container maxWidth="xs">
                <Box
                    component="form"
                    onSubmit={handleLogin}
                    sx={{ mt: 4, display: 'flex', flexDirection: 'column', gap: 2 }}
                >
                    <Typography variant="h5" component="h1" align="center">
                        Login
                    </Typography>

                    {error && (
                        <Typography variant="body2" color="error" align="center">
                            {error}
                        </Typography>
                    )}

                    <TextField
                        label="Username"
                        variant="outlined"
                        fullWidth
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />

                    <TextField
                        label="Password"
                        variant="outlined"
                        type="password"
                        fullWidth
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />

                    <Button type="submit" variant="contained" color="primary" fullWidth>
                        Login
                    </Button>
                </Box>
            </Container>
        </>
    )
}

export default Login;