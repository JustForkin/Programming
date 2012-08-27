function [ isEquiv ] = EquivCircuits( a, b, c, d )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
    
    C = eye(16);
    C(5, 5) = 0;
    C(6, 6) = 0;
    
    U = zeros(16);
    U(5,5) = a;
    U(5,6) = b;
    U(6,5) = c;
    U(6,6) = d;
    
    U3 = U^3;
    
    C1 = C + U;
    C2 = C + U3;
    
    maxNorm = norm(C1-C2);
    
    epsilon = 10^-4;
    
    if maxNorm < epsilon
        isEquiv = true;
        disp('YES');
        disp(' ');
    else
        isEquiv = false;
        disp('NO');
        disp(' ');
    end
        
end


