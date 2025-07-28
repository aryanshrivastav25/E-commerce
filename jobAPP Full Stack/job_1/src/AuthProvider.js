import { useState } from "react";
import AuthContext from "./AuthContext";

function AuthProvider({children}) {
    const [isAuthenticated, setIsAuthenticated] = useState(() => localStorage.getItem('isAuthenticated'));

    const login = () => {
        setIsAuthenticated(true);
        localStorage.setItem('isAuthenticated', 'true');
    }

    const logout = () => {
        setIsAuthenticated(false);
        localStorage.removeItem('isAuthenticated');
    }
    return (
        <AuthContext.Provider value={{isAuthenticated, login, logout}}>
            {children}
        </AuthContext.Provider>
    )
}

export default AuthProvider;