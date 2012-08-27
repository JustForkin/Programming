function [ Mf ] = Grover( n, x0 )
% Performs Grover's Search algorithm
% n = number of input bits for the function f
% x0 = the index x0={0,...,2^n-1} for which f(x0)=1

    
    state0 = [1; 0];
    state1 = [0; 1];
    H = [1 1; 1 -1]/2^.5;
    I = [1 0; 0 1];
    X = [0 1; 1 0];
    
    N = 2^n;
    k = ceil(pi*(2^(n/2))/4); %%%%%%%%%%%%%%%%%
    
    Hn = H;
    for i = 1:n-1
        Hn = kron(Hn, H);
    end
    
    top = state0;
    for i = 1:n-1
        top = kron(top, state0);
    end
    bot = state1;
    
    top = (Hn*top);
    bot = (H*bot);
    
    Uf = zeros(2*N, 2*N);
    for j = 1:N
        Utemp = zeros(2*N, 2*N);
        %tempF = F(j);
        tempA = A(F(j-1));
        Utemp(2*j-1,2*j-1) = tempA(1,1);
        Utemp(2*j-1,2*j) = tempA(1,2);
        Utemp(2*j,2*j-1) = tempA(2,1);
        Utemp(2*j,2*j) = tempA(2,2);
        Uf = Uf + Utemp;
    end
    
    both = kron(top, bot);  %%%%%%%%%%%%%
    
    S0 = -eye(N);
    S0(1,1) = 1;
    
    %G = eye(2*N);
    G = Uf;
    %size(G)
    %size(kron(Hn, I))
    G = kron(Hn, I) * G;
    G = kron(S0, I) * G;
    G = kron(Hn, I) * G;
    %G = Uf * G  
    G; %%%%%%%%%%%%%%%%%%%%%%%%%
    
    Gk = G;
    for i = 1:k-1
        Gk = Gk * G;
    end
    Gk; %%%%%%%%%%%%
    both = Gk * both; 
    
    both;  %%%%%%%%%%%%%%%
    
    %%%  take biggest for answer
    max = norm( both( 2*(x0+1) ) );
    maxCoord = (2*(x0+1));
    for i = 2:2:N*2
        temp = norm(both(i));
        if(temp > max)
            max = temp;
            maxCoord = i;
        end
    end
    maxCoord = maxCoord/2;
    maxState = maxCoord - 1;
    Mf = maxState;
    
    %%% output result  %%%
    fprintf('f(x_0) = 1 for x_0 =?');
    Mf
    if Mf == x0
        fprintf('and this is correct.\n');
    else fprintf('and this is incorrect.\n');
    end
    
    
    
    
    function [ mat ] = A( isI )
        if isI == 0
            mat = I;
        else mat = X;
        end
    end

    function [ ret ] = F( x )
        if x == x0
            ret = 1;
        else ret = 0;
        end
    end


end