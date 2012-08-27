function [] = PEtester()
    
    disp('*NEW TEST CASE*');
    disp(sprintf('\n'));
    U1 = [1 0; 0 -1];
    u1 = [0;1];
    QPhaseEstim(U1, u1, 2, 0.25);
    
    disp(sprintf('\n'));
    disp('*NEW TEST CASE*');
    disp(sprintf('\n'));
    U2 = [exp(1i*pi/2) 0 0 0; 0 exp(1i*pi/3) 0 0; 0 0 exp(1i*pi/4) 0; 0 0 0 exp(1i*pi/5)];
    u2 = [exp(1i*pi/2); 0; 0; 0];
    QPhaseEstim(U2, u2, 2, 0.25);
     
    disp(sprintf('\n'));
    disp('*NEW TEST CASE*');
    disp(sprintf('\n'));
    u4 = [0; exp(1i*pi/3); 0; 0];
    QPhaseEstim(U2, u4, 2, 0.25);
    
    disp(sprintf('\n'));
    disp('*NEW TEST CASE*');
    disp(sprintf('\n'));
    u3 = [0; 0; exp(1i*pi/4); 0];
    QPhaseEstim(U2, u3, 2, 0.25);
    
    disp(sprintf('\n'));
    disp('*NEW TEST CASE*');
    disp(sprintf('\n'));
    u5 = [0; 0; 0; exp(1i*pi/5)];
    QPhaseEstim(U2, u5, 4, 0.25);
end