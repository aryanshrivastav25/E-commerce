import { Box, Button, Container, Grid, TextField, Typography } from "@mui/material";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axiosInstance from "../axiosConfig";

function Register() {
    const [formData, setFormData] = useState({
        name: '',
        firstname: '',
        lastname: '',
        password: '',
        confirmPassword: ''
    });

    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({...formData, 
            [e.target.name]: e.target.value})
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (formData.password !== formData.confirmPassword)
        {
            setError("Passwords do not match");
            return;
        }

        try
        {
            const response = await axiosInstance.post('http://localhost:8080/register', formData);
            
            if (response.status === 200)
                navigate('/registrationSuccess');
            else
            {
                const errorText = await response.text();
                setError(errorText);
            }

        }
        catch(e)
        {
            setError('An error occurred ', e.message)
        }
    }

    return (
        <>
            <Container maxWidth="xs">
                <Box sx={{ mt: 8 }}>
                    <Typography variant="h5" align="center" gutterBottom>
                        Register
                    </Typography>

                    <form onSubmit={handleSubmit}>
                        <Grid container spacing={2}>
                            <Grid item xs={12}>
                                <TextField
                                    label="First Name"
                                    name="firstname"
                                    fullWidth
                                    value={formData.firstname}
                                    onChange={handleChange}
                                    required
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    label="Last Name"
                                    name="lastname"
                                    fullWidth
                                    value={formData.lastname}
                                    onChange={handleChange}
                                    required
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    label="Username"
                                    name="username"
                                    fullWidth
                                    value={formData.username}
                                    onChange={handleChange}
                                    required
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    label="Password"
                                    name="password"
                                    type="password"
                                    fullWidth
                                    value={formData.password}
                                    onChange={handleChange}
                                    required
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    label="Confirm Password"
                                    name="confirmPassword"
                                    type="password"
                                    fullWidth
                                    value={formData.confirmPassword}
                                    onChange={handleChange}
                                    required
                                />
                            </Grid>
                            {error && (
                                <Grid item xs={12}>
                                    <Typography color="error" variant="body2">
                                        {error}
                                    </Typography>
                                </Grid>
                            )}
                            <Grid item xs={12}>
                                <Button type="submit" fullWidth variant="contained" color="primary">
                                    Register
                                </Button>
                            </Grid>
                        </Grid>
                    </form>
                </Box>
            </Container>
        </>
    )
}

export default Register;